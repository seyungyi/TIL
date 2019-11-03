# [ Java Install Method ]

## Direct Down and Install Method



## Installer Packages Method

```bash
$ tar zxvf jdk-8u144-linux-x64.tar.gz

$ sudo mkdir /usr/lib/jvm

$ sudo mv jdk1.8.0_144 /usr/lib/jvm

$ sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_144/bin/java 1

$ sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.8.0_144/bin/javac 1

$ sudo update-alternatives --install /usr/bin/javaws javaws /usr/lib/jvm/jdk1.8.0_144/bin/javaws 1

$ sudo update-alternatives --config java

$ sudo update-alternatives --config javac

$ sudo update-alternatives --config javaws
```