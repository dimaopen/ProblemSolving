from types import FunctionType


def reg_fun():
    print("reg_fun")

print(reg_fun.__name__)


code = compile('print("Hello, world!")', '<repl>', 'eval')
func = FunctionType(code, globals(), 'greetings')

func()