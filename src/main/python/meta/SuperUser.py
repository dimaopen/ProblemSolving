class User:
    def __init__(self, name):
        self.name = name

class SuperUser(User):
    """Encapsulate domain logic to work with super users"""
    group_name = 'admin'

    @property
    def login(self):
        return f'{self.group_name}/{self.name}'.lower()

# Теперь создадим аналог класса SuperUser "динамически"
CustomSuperUser = type(
    # Название класса
    'SuperUser',
    # Список классов, от которых новый класс наследуется
    (User, ),
    # Атрибуты и методы нового класса в виде словаря
    {
        '__doc__': 'Encapsulate domain logic to work with super users',
        'group_name': 'admin',
        'login': property(lambda self: f'{self.group_name}/{self.name}'.lower()),
    }
)

assert SuperUser.__doc__ == CustomSuperUser.__doc__
assert SuperUser('Vladimir').login == CustomSuperUser('Vladimir').login