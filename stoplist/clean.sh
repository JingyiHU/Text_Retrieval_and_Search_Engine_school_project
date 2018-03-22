#!/bin/bash

sed -r "/^([0-9]|=http)/d" $@
