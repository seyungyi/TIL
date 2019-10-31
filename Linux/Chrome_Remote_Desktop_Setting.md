# [ Chrome Remote Desktop Setting ]

## stop chrome remote desktop:

```bash
# /opt/google/chrome-remote-desktop/chrome-remote-desktop --stop
```

## Backup the original configuration:

```bash
# sudo cp /opt/google/chrome-remote-desktop/chrome-remote-desktop /opt/google/chrome-remote-desktop/chrome-remote-desktop.orig
```

## Edit the config file (sudo vim, gksudo gedit, etc):

```bash
# sudo gedit /opt/google/chrome-remote-desktop/chrome-remote-desktop

Find DEFAULT_SIZES and amend to the remote desktop resolution. For example:
DEFAULT_SIZES = "1920x1080"
FIRST_X_DISPLAY_NUMBER = 0
```

## OverView Stemps:

```bash
# wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

# sudo dpkg -i google-chrome-stable_current_amd64.deb
```

### Install Chrome, sign-in, install Chrome Remote Desktop, launch & download the installer.

```bash
# sudo dpkg -i ~/Downloads/chrome-remote-desktop_current_amd64.deb

#sudo apt-get install -f

#sudo usermod -a -G chrome-remote-desktop $USER

#sudo reboot

# Monkey patch # /opt/google/chrome-remote-desktop/chrome-remote-desktop following the Stack Overflow superuser post

Launch Chrome Remote Desktop and do “Enable remote connections” 
```



