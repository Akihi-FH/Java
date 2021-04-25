#! /bin/bash

jps_pid=$(jps | grep TaskManagerRunner| awk '$1>0 {print $1}'|head -1)
echo "jps_pid:"  $jps_pid

pid=$1
if [ -n $pid ]; then
  echo "pid: "  $pid
fi

while :
do
  if [ -n $jps_pid ]; then
    current=$(date "+%Y-%m-%d %H:%M:%S")
    timeStamp=$(date -d "$current" +%s)
    if [ -z "$2" ]; then
      echo "time;$timeStamp;$current"
      #eval ps up $jps_pid -L | awk 'NR>6{print $2";"$3";"$4";"$6";"$11";"$12}'
      eval top -bp $jps_pid -n 1 | awk 'NR>7{if(NF>0) print $1";"$9";"$10";"$11}'
    else
      echo "time;$timeStamp;$current" >> $2
      # echo "$jps_pid" >> $2
      #eval ps up $jps_pid -L | awk 'NR>1{print $2";"$3";"$4";"$6";"$11";"$12}' >> $2
      eval top -bp $jps_pid -n 1 | awk 'NR>7{if(NF>0) print $1";"$9";"$10";"$11}' >> $2
    fi
  fi
  sleep 1
done
