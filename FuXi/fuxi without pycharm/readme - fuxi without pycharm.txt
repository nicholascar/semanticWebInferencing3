https://pip.pypa.io/en/latest/installing/#python-os-support
https://code.google.com/archive/p/fuxi/wikis/Installation_Testing.wiki

runcmd.bat and type
D:\Programming\Python\Python2.7.14\python get-pip.py

then
D:\Programming\Python\Python2.7.14\python -m pip install --upgrade pip

then
D:\Programming\Python\Python2.7.14\Scripts\pip install http://cheeseshop.python.org/packages/source/p/pyparsing/pyparsing-1.5.5.tar.gz

https://github.com/ptwobrussell/Mining-the-Social-Web-2nd-Edition/issues/293
Download the fuxi source archive from https://storage.googleapis.com/google-code-archive-source/v2/code.google.com/fuxi/source-archive.zip
Extract the file fuxi/layercake-python.tar.bz2

then
D:\Programming\Python\Python2.7.14\Scripts\pip install layercake-python.tar.bz2

then
D:\Programming\Python\Python2.7.14\Scripts\pip install setuptools
(it was already installed)

then
D:\Programming\Python\Python2.7.14\Scripts\pip install https://pypi.python.org/packages/source/F/FuXi/FuXi-1.4.1.production.tar.gz
says
error: Microsoft Visual C++ 9.0 is required. Get it from http://aka.ms/vcpython27
at first I installed:
https://www.microsoft.com/en-us/download/details.aspx?id=44266
Microsoft Visual C++ Compiler for Python 2.7

then install the pre-requisites for the MS Visual C++ Compiler for Python 2.7:
- Microsoft Visual C++ 2008 SP1 Redistributable Package (x86, x64) https://www.microsoft.com/en-us/download/confirmation.aspx?id=2092 -> vcredist_x64.exe
(this was already installed)
- Windows 8 and later require the Microsoft .NET Framework 3.5. See here for installation instructions. https://docs.microsoft.com/en-us/dotnet/framework/install/dotnet-35-windows-10
Press the Windows key Windows Windows logo on your keyboard, type "Windows Features", and press Enter. The Turn Windows features on or off dialog box appears.
Select the .NET Framework 3.5 (includes .NET 2.0 and 3.0) check box, select OK, and reboot your computer if prompted.
(this was already done)

then I uninstalled "Microsoft Visual C++ Compiler for Python 2.7" because I was getting the error message:
error: command 'C:\\Users\\Jevan\\AppData\\Local\\Programs\\Common\\Microsoft\\Visual C++ for Python\\9.0\\VC\\Bin\\amd64\\cl.exe' failed with exit status 2

----------------------------------------------------------------

Ref: https://stackoverflow.com/questions/39771592/visual-c-for-python-failed-with-exit-status-2-when-installing-divisi2
I now install "gcc-mingw-4.3.3-setup.exe" from
https://github.com/develersrl/gccwinbinaries/releases

Quick guide for installing GCC for Python development

    Run the installer and follow instructions.
    If possible, don't select an installation path with whitespaces in it. There is no outstanding bug about this ''right now'', but don't abuse your luck.
    Make sure that the box Add GCC to your system PATH is checked.
    Make sure that the box Bind to Python installations is checked.
    Make sure that the box Set the default runtime library is checked. Then, select the library you need:
        For Python 2.6, 2.7, 3.x, you want MSVCR90.DLL
        For Python 2.4 or 2.5, you want MSVCR71.DLL
        For Python 2.3 or older, you want MSVCRT.DLL
    Mark which Python installations will use GCC by default. It's really up to you :)

If you work on multiple Python versions, you will need to switch the runtime library after installation. You can do that at any time with the gccmrt script (see below).

I installed it to d:\programming\mingw
and selected to Link with MSVCR90.DLL
The only version of python that was detect is Python 3.5 (C:\Anaconda3)
Even adding the python 3.6.4 and 2.7.14 folders
D:\Programming\Python\Python2.7.14
D:\Programming\Python\Python3.6.4
to the path doesn't make any difference it still doesn't detect those.
Maybe if I added the Scripts folder for each it might work, but i see no point in trying that.

----------------------------------------------------------------

Uninstalled "Python 3.5.1 (Anaconda3 2.5.0 32-bit)" since it appears that could
be what's causing the problems.

https://docs.python.org/3/install/index.html?highlight=distutils%20cfg
https://github.com/pypa/pip/issues/18
https://docs.python.org/3/install/index.html?highlight=distutils%20cfg#inst-config-files

add to user path in system environment variables: D:\Programming\mingw\bin
removed from system path in system environment variables: D:\Programming\mingw\bin
removed python 2.7.14 and 3.6.4 folders from the user path

then
D:\Programming\Python\Python2.7.14\Scripts\pip install https://pypi.python.org/packages/source/F/FuXi/FuXi-1.4.1.production.tar.gz --global-option build_ext --global-option --compiler=mingw32

gives error message:
collect2: ld returned 1 exit status
    error: command 'D:\\Programming\\mingw\\bin\\gcc.exe' failed with exit status 1

----------------------------------------------------------------

Reinstalled
"Python 3.5.1 (Anaconda3 2.5.0 32-bit)"
from D:\Data\Downloads\_Have Installed\Programming\ruby with nyaplot\
since uninstalling it had made no difference.
Note I only reinstalled it once, but this has been noted into both
_github\semanticWebInferencing3\FuXi\readme - PycharmProjects.txt
and
_github\semanticWebInferencing3\FuXi\fuxi without pycharm\readme - fuxi without pycharm.txt

----------------------------------------------------------------

