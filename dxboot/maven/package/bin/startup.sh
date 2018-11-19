#!/bin/sh
# SCRIPT: emp app start script
# AUTHOR: 
# DATE: 2012

#source ~/.bashrc
export LANG="zh_CN.UTF-8"
export JAVA_HOME=/usr/local/java/jdk1.8.0_161
export PATH=$JAVA_HOME/bin:$PATH

USER=`whoami`
PWD=$(cd `dirname $0`; pwd)

cd $PWD

#execute app.conf script
. $PWD/app.conf

JAVA_DEBUG=""
if [ $ISDEBUG -eq "1" ]; then
	JAVA_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,address=$8087,server=y,suspend=n"
fi

libpath=".:"
for path in ../lib/*.jar
do
        libpath=$libpath"$path:"
done

PID=`ps -o args,pid  | fgrep "["$APPID"]" | grep -v grep | awk '{print $NF}'`

if [ -z "$PID" ]; then
	java -D[$APPID] $XMX $XMS $XMN $GC $JAVA_DEBUG -DNID=$1 -cp ../config:$libpath com.dixn.dxboot.DxbootApplication &
	echo "$APPID is started up at $DATE by $USER." | tee -a  $PWD/app_log.log
else
	echo "$APPID has been started."
fi
tail -f $PWD/app.conf
