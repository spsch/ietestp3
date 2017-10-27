import sys
import platform
import os

print sys.version_info
print platform.architecture
print os.environ["PROGRAMFILES(X86)"]
print os.name
print platform.uname()
print platform.win32_ver()