Pycharm Projects I have made here

------------------------------------------------------

rdflib1:

File, Settings, Project:rdflib1, Project Interpreter
+
rdflib (default of 4.2.2)

added a main.py and copy in relatives.ttl

Works (but no inferencing)

------------------------------------------------------

rdflib2:

https://github.com/RDFLib/OWL-RL

Here I am trying to use fuxi. However it seems that both fuxi and owl-rl have
the problem that they use python 2, not python 3. Fuxi is in the pip list
but owl-rl is not.

https://code.google.com/archive/p/fuxi/wikis/Installation_Testing.wiki
https://pypi.python.org/pypi/FuXi/
https://code.google.com/archive/p/fuxi/

Fuxi requires layercake (preferred) and it is not compatible with rdflib 3.+ or 4+

File, Settings, Project:rdflib2, Project Interpreter
+
layercake 0.4.0
pyparsing 2.2.0
ez_setup 0.9

tried to install the following but got errors:

1. rdflib 2.4.2 (2.4.1 would also be okay)

Collecting rdflib==2.4.2
  Using cached rdflib-2.4.2.tar.gz
    Complete output from command python setup.py egg_info:
    Traceback (most recent call last):
      File "<string>", line 1, in <module>
      File "C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\rdflib\setup.py", line 6, in <module>
        from rdflib import __version__, __date__
      File "C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\rdflib\rdflib\__init__.py", line 15, in <module>
        from rdflib.URIRef import URIRef
      File "C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\rdflib\rdflib\URIRef.py", line 13, in <module>
        from urlparse import urlparse, urljoin, urldefrag
    ModuleNotFoundError: No module named 'urlparse'
    
    ----------------------------------------

Command "python setup.py egg_info" failed with error code 1 in C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\rdflib\

The problem appears to be because rdflib 2.4.2 is designed for python 2, not python 3.
https://github.com/FriendCode/gittle/issues/49

2. fuxi 1.4.1.production

Collecting FuXi
  Using cached FuXi-1.0-rc.dev.tar.gz
    Complete output from command python setup.py egg_info:
    Downloading http://pypi.python.org/packages/source/d/distribute/distribute-0.6.14.tar.gz
    Traceback (most recent call last):
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 143, in use_setuptools
        raise ImportError
    ImportError
    
    During handling of the above exception, another exception occurred:
    
    Traceback (most recent call last):
      File "<string>", line 1, in <module>
      File "C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\FuXi\setup.py", line 2, in <module>
        ez_setup.use_setuptools()
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 145, in use_setuptools
        return _do_download(version, download_base, to_dir, download_delay)
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 124, in _do_download
        to_dir, download_delay)
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 193, in download_setuptools
        src = urlopen(url)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 223, in urlopen
        return opener.open(url, data, timeout)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 532, in open
        response = meth(req, response)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 642, in http_response
        'http', request, response, code, msg, hdrs)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 570, in error
        return self._call_chain(*args)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 504, in _call_chain
        result = func(*args)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 650, in http_error_default
        raise HTTPError(req.full_url, code, msg, hdrs, fp)
    urllib.error.HTTPError: HTTP Error 403: SSL is required
    
    ----------------------------------------

Command "python setup.py egg_info" failed with error code 1 in C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\FuXi\

See https://github.com/nltk/nltk/issues/1879

3. fuxi 1.4.1.production options -i https://pypi.python.org/simple/

Collecting FuXi
  Using cached FuXi-1.0-rc.dev.tar.gz
    Complete output from command python setup.py egg_info:
    Downloading http://pypi.python.org/packages/source/d/distribute/distribute-0.6.14.tar.gz
    Traceback (most recent call last):
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 143, in use_setuptools
        raise ImportError
    ImportError
    
    During handling of the above exception, another exception occurred:
    
    Traceback (most recent call last):
      File "<string>", line 1, in <module>
      File "C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\FuXi\setup.py", line 2, in <module>
        ez_setup.use_setuptools()
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 145, in use_setuptools
        return _do_download(version, download_base, to_dir, download_delay)
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 124, in _do_download
        to_dir, download_delay)
      File "D:\Data\Other\_volunteering\2018\_successful\www.csiro.au\_volunteer for nicholas car\PycharmProjects\rdflib2\venv\lib\site-packages\ez_setup.py", line 193, in download_setuptools
        src = urlopen(url)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 223, in urlopen
        return opener.open(url, data, timeout)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 532, in open
        response = meth(req, response)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 642, in http_response
        'http', request, response, code, msg, hdrs)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 570, in error
        return self._call_chain(*args)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 504, in _call_chain
        result = func(*args)
      File "D:\Programming\Python\Python36\Lib\urllib\request.py", line 650, in http_error_default
        raise HTTPError(req.full_url, code, msg, hdrs, fp)
    urllib.error.HTTPError: HTTP Error 403: SSL is required
    
    ----------------------------------------

Command "python setup.py egg_info" failed with error code 1 in C:\Users\Jevan\AppData\Local\Temp\pycharm-packaging\FuXi\

------------------------------------------------------

