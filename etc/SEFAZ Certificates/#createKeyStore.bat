REM @echo off
setlocal enabledelayedexpansion

if exist sefazca.jks del sefazca.jks
cls

set KEYSTORE=sefazca.jks
set STOREPASS=sefazca

for %%f in (*.crt) do (
    set ALIAS=%%~nf
	echo Adicionando o arquivo %%f
	"c:\Program Files\java\jdk1.8.0_301\bin\keytool.exe" -importcert -file "%%f" -keystore %KEYSTORE% -storepass %STOREPASS% -alias "!ALIAS!" -noprompt
	echo.
)

endlocal
