import inspect
from abc import ABCMeta, abstractmethod

class RegistryMeta(ABCMeta):
    """
    Метакласс, который создает реестр из классов наследников.
    Реестр хранит ссылки вида "формат файла" -> "класс плагина"
    """
    _registry_formats = {}

    def __new__(mcs, name, bases, attrs):
        cls: 'BasePlugin' = super().__new__(mcs, name, bases, attrs)
        print(name)
        # не обрабатываем абстрактные классы (BasePlugin)
        if inspect.isabstract(cls):
            return cls

        for media_format in cls.supported_formats:
            if media_format in mcs._registry_formats:
                raise ValueError(f'Format {media_format} is already registered')

            # сохраняем ссылку на плагин в реестре
            mcs._registry_formats[media_format] = cls

        return cls

    @classmethod
    def get_plugin(mcs, media_format: str):
        try:
            return mcs._registry_formats[media_format]
        except KeyError:
            raise RuntimeError(f'Plugin is not defined for {media_format}')

    @classmethod
    def show_registry(mcs):
        from pprint import pprint
        pprint(mcs._registry_formats)


class BasePlugin(metaclass=RegistryMeta):
    """
    Атрибут класса supported_formats и метод run обязаны быть реализованы
    в наследниках этого класса
    """
    @property
    @abstractmethod
    def supported_formats(self) -> list:
        pass

    @abstractmethod
    def run(self, input_data: dict):
        pass

class VideoPlugin(BasePlugin):
    supported_formats = ['mpg', 'mov']
    def run(self, input_data):
        print(f"VideoPlugin run: {input_data}")

RegistryMeta.show_registry()
print()
plugin = RegistryMeta.get_plugin('mp3')
print(plugin)

plugin().run({})