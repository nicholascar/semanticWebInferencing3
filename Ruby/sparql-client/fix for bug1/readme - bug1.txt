Fix for error: Process::RLIMIT_NOFILE is not defined in Windows version

Full error output from running it is

C:/Ruby24/lib/ruby/gems/2.4.0/gems/net-http-persistent-3.0.0/lib/net/http/persistent.rb:205:in `<class:Persistent>': uninitialized constant Process::RLIMIT_NOFILE (NameError)
	from C:/Ruby24/lib/ruby/gems/2.4.0/gems/net-http-persistent-3.0.0/lib/net/http/persistent.rb:190:in `<top (required)>'
	from C:/Ruby24/lib/ruby/2.4.0/rubygems/core_ext/kernel_require.rb:55:in `require'
	from C:/Ruby24/lib/ruby/2.4.0/rubygems/core_ext/kernel_require.rb:55:in `require'
	from C:/Ruby24/lib/ruby/gems/2.4.0/gems/sparql-client-3.0.0/lib/sparql/client.rb:1:in `<top (required)>'
	from C:/Ruby24/lib/ruby/2.4.0/rubygems/core_ext/kernel_require.rb:133:in `require'
	from C:/Ruby24/lib/ruby/2.4.0/rubygems/core_ext/kernel_require.rb:133:in `rescue in require'
	from C:/Ruby24/lib/ruby/2.4.0/rubygems/core_ext/kernel_require.rb:40:in `require'
	from program1.rb:2:in `<main>'

Fix is to edit line 205 of persistent.rb in C:\Ruby24\lib\ruby\gems\2.4.0\gems\net-http-persistent-3.0.0\lib\net\http\

original code:

DEFAULT_POOL_SIZE = Process.getrlimit(Process::RLIMIT_NOFILE).first / 4

replaced with the following code:

if Gem.win_platform? then
	DEFAULT_POOL_SIZE = 256

else

	DEFAULT_POOL_SIZE = Process.getrlimit(Process::RLIMIT_NOFILE).first / 4

end

Reference:

https://github.com/drbrain/net-http-persistent/issues/79
https://github.com/drbrain/net-http-persistent/pull/90/files


