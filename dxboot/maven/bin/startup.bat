@echo off
rem ======================================================================
rem windows startup script
rem
rem author: zhaoxu
rem date: 2019-01-31
rem ======================================================================

rem startup jar
java -jar ../boot/dxboot.jar --spring.config.location=../config/

pause