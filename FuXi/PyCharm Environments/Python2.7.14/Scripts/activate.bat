@echo off
set "VIRTUAL_ENV=D:\Data\Other\_VOLUN~1\2018\_SUCCE~1\WWWCSI~1.AU\_VOLUN~1\_github\SEMANT~4\FuXi\PYCHAR~2\PYTHON~1.14"

if defined _OLD_VIRTUAL_PROMPT (
    set "PROMPT=%_OLD_VIRTUAL_PROMPT%"
) else (
    if not defined PROMPT (
        set "PROMPT=$P$G"
    )
    set "_OLD_VIRTUAL_PROMPT=%PROMPT%"
)
set "PROMPT=(PYTHON~1.14) %PROMPT%"

REM Don't use () to avoid problems with them in %PATH%
if defined _OLD_VIRTUAL_PYTHONHOME goto ENDIFVHOME
    set "_OLD_VIRTUAL_PYTHONHOME=%PYTHONHOME%"
:ENDIFVHOME

set PYTHONHOME=

REM if defined _OLD_VIRTUAL_PATH (
if not defined _OLD_VIRTUAL_PATH goto ENDIFVPATH1
    set "PATH=%_OLD_VIRTUAL_PATH%"
:ENDIFVPATH1
REM ) else (
if defined _OLD_VIRTUAL_PATH goto ENDIFVPATH2
    set "_OLD_VIRTUAL_PATH=%PATH%"
:ENDIFVPATH2

set "PATH=%VIRTUAL_ENV%\Scripts;%PATH%"