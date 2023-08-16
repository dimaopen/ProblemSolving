from meta.plugin_registry import BasePlugin


class AudioPlugin(BasePlugin):
    supported_formats = ['mp3', 'flac']
    def run(self):
        print("AudioPlugin run")