#! /bin/bash

#nodes=(m1-medium-2 m1-medium-3 m1-medium-4
#       m1-large-1 m1-large-2 m1-large-3 m1-large-4
#       m1-xlarge-1 m1-xlarge-2 m1-xlarge-3 m1-xlarge-4)
nodes=(m1-medium-2 m1-medium-3 m1-medium-4
       m1-large-1 m1-large-2 m1-large-3 m1-large-4
       m1-xlarge-1 m1-xlarge-2 m1-xlarge-3 m1-xlarge-4)

for i in ${nodes[@]}
do
        echo --------- $i ----------
        ssh $i "$*" &
done