#! /bin/bash

jps_pid=$(jps | grep TaskManagerRunner| awk '$1>0 {print $1}'|head -1)
echo "$jps_pid" > /opt/fh/logs/pid-m1-medium-1.txt

num=$(wc -l pid-m1-medium-1.txt |awk '{print $1}')
echo "$num"
if [ 1 -eq $num ]; then
  echo "work-1"
#  ./Mymonitor  $(jps | grep TaskManagerRunner | awk '$1>0 {print $1}' | head -1)  /opt/fh/logs/work-m1-medium-1.txt &
  nohup /opt/fh/monitor_scripts/Mymonitor  $(jps | grep TaskManagerRunner | awk '$1>0 {print $1}' | head -1)  /opt/fh/logs/work-m1-medium-1.txt &
fi