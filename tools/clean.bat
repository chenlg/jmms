@echo off
echo [CMMI] clean .
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m 

cd .. 
call %MVN%  clean eclipse:clean

goto end 

:end
pause