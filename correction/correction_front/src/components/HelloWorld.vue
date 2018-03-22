<template>
  <div class="hello">
    <div class="query-box">
      <input v-model="query" v-on:input="fetchData" placeholder="Requête" class="form-control">
    </div>
    <div v-if="loading" class="query-status bg-info">
      Loading...
    </div>
    <div class="file-preview" v-if="filename !== ''">
      <div class="file-preview-header">
        <div class="file-preview-header-title">
          {{ filename }}
        </div>
        <div class="file-preview-header-close">
          <span v-on:click="closeFile()" class="link">X</span>
        </div>
      </div>
      <iframe class="file-preview-container" v-bind:src="'/api/?file=' + filename">
      </iframe>
    </div>
    <div class="query-results row" v-bind:class=" { loading: loading }" v-else>
      <div class="query-description">
        <div>
          <pre>
            {{ finalQuery }}
          </pre>
        </div>
      </div>
      <div class="query-data">
        <div>
          <div v-if="data.length > 0" class="table-responsive">
            <table class="table table-striped">
              <thead>
                <th v-for="col in columns">
                  {{ col }}
                </th>
              </thead>
                <transition-group name="slide-fade" tag="tbody">
                  <tr v-for="item in data" v-bind:key="JSON.stringify(item)">
                    <td v-for="col in columns">
                      <span class="link" v-if="col === 'fichier'" v-on:click="fetchFile(item[col])">{{ item[col] }}</span>
                      <span v-else>{{ item[col] }}</span>
                    </td>
                  </tr>
                </transition-group>
            </table>
          </div>
          <div v-else>Pas de résultats</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      query: '',
      finalQuery: '',
      data: [],
      columns: [],
      filename: '',
      requestTimeout: null,
      loading: false,
    };
  },
  methods: {
    fetchData() {
      this.loading = true;
      clearTimeout(this.requestTimeout);
      this.requestTimeout = setTimeout(() => {
        fetch(`/api/?query=${encodeURIComponent(this.query)}`)
          .then((response) => {
            if (response.status !== 200) {
              console.log(`Looks like there was a problem. Status Code: ${response.status}`);
              this.data = [];
              this.columns = [];
              return;
            }

            // Examine the text in the response
            response.json().then((r) => {
              let data = r.data;
              this.finalQuery = r.query;
              this.data = data;
              this.columns = Object.keys(data[0] || {}).filter(c => c !== "mots");
            });

            this.loading = false;
          })
          .catch((err) => {
            console.log('Fetch Error :-S', err);
            this.data = [];
            this.columns = [];

            this.loading = false;
          });
      }, 200);
    },
    fetchFile(file) {
      console.log(`Fetching file ${file}`);
      this.filename = file;
    },
    closeFile() {
      this.filename = '';
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* Enter and leave animations can use different */
/* durations and timing functions.              */
.slide-fade-enter-active {
  transition: all .15s ease;
}
.slide-fade-leave-active {
  transition: all .3s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}

.hello {
  padding: 1rem;
  height: 100%;
  display: flex;
  flex-direction: column;
  flex: 1 0 auto;

  

}
.query-box {
  flex: none;
  padding: 1rem;
}

.query-results {
  flex: 1 1 auto;
  display: flex;
  overflow: hidden;
}

.query-description {
  flex: 1 0 auto;
  display: flex;
  flex-direction: column;
  margin-right: 1rem;
  overflow: auto;
  height: 100%;
}

.query-data {
  flex: 2 0 0;
  overflow: auto;
  height: 100%;
}

.query-status {
  margin: 1rem;
  padding: 1rem;
  text-align: center;
}

pre {
  text-align: left;
  padding: 0.5rem;
  background-color: lightblue;
  font-size: 1rem;
}

.results-col {
  overflow: auto;
  height: 100%;
}

.file-preview {
  display: flex;
  flex: 1 0 auto;
  flex-direction: column;
}

.file-preview-container {
  flex: 1 0 auto;
  width: 100%;
}

.file-preview-header {
  padding: 1rem;
  font-size: 2rem;
  background-color: lightblue;
  display: flex;
  flex-direction: row;
  position: relative;
}

.file-preview-header-title {
  flex: 1 0 auto;
}
.file-preview-header-close {
  position: absolute;
  right: 0;
  padding-right: 1rem;
}

.link {
  cursor:pointer;
  color:blue;
  text-decoration:underline;
}

.link:hover {
     text-decoration:none;
     text-shadow: 1px 1px 1px #555;
}

.loading {
  opacity: 0.4;
}
</style>
