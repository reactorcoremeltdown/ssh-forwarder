all: build

build:
	echo "Building app"
	test -d /tmp/gradlecache || mkdir /tmp/gradlecache
	podman run -it --memory 2g -v $(shell pwd):/project -v /tmp/gradlecache:"/root/.gradle" mingc/android-build-box bash -c 'cd /project; ./gradlew build'

publish:
	rm -fr /var/lib/fdroid/unsigned/*
	mv /var/storage/wastebox/Backups/ssh-forwarder-unsigned.apk /var/lib/fdroid/unsigned/space.rcmd.sshdeeplink_$(shell date '+%s').apk
	touch /var/lib/fdroid/metadata/space.rcmd.sshdeeplink.yml
	cd /var/lib/fdroid && \
		/opt/fdroidserver/fdroid publish --verbose && \
		/opt/fdroidserver/fdroid update --verbose && \
		/opt/fdroidserver/fdroid deploy --verbose
