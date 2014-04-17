@echo off
echo [CMMI] eclipse .
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m 

cd .. 
call %MVN%  clean eclipse:clean eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true

goto end 

:end
pause
