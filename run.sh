#!/usr/local/bin/bash

for i in {1..2}
do
    cp src/* reidai0${i}/
    cd reidai0${i}
    javac Solver.java
#    for j in {1..50}
#    do
#       echo $j
        java Gold
#    done
    ls ../src | xargs rm
    cd ../
done

