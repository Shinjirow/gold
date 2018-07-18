#!/usr/local/bin/bash

for i in {1..2}
do
    cp src/* reidai0${i}/
    cd reidai0${i}
    javac Solver.java && java Gold 2> res.levy.csv
    ls ../src | xargs rm
    cd ../
done

