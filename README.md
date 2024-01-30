# SSH Forwarder

A glue Android app to open `ssh://` links in Termux.

## Motivation

As of today Termux does not support opening `ssh://` links natively, and I needed something working for quickly jumping to my hosts from Gotify and Telegram alerts.

## Demo

![](media/output.gif)

## How to install

1. Install [an apk from releases](https://github.com/reactorcoremeltdown/ssh-forwarder/releases/download/v1.0/app-release.apk)
2. Download and install [a task for Tasker](https://github.com/reactorcoremeltdown/ssh-forwarder/blob/master/tasker/Open_Termux_SSH.tsk.xml)
3. Download and install [a profile for Tasker](https://github.com/reactorcoremeltdown/ssh-forwarder/blob/master/tasker/Catch_SSH.prf.xml)
4. Install the [Termux Tasker Plugin](https://f-droid.org/en/packages/com.termux.tasker/)
5. Put [a script](https://github.com/reactorcoremeltdown/ssh-forwarder/blob/master/termux/ssh_forwarder) into `~/.termux/tasker/` folder of your Termux installation
6. You should be good to go!
7. Optionally use [HTTP2SSH](https://http2ssh.tiredsysadmin.cc) to wrap your `ssh://` links into `https://`

## Note on distribution of the app and contribution to Termux's upstream

I'm an SRE, I juggle YAML files for living, and I know woefully little about Android's app distribution. I made this glue thingy out of total despair, following the only path I know: hacking scripts together. If you wish to improve the overall UX of this thing, I'm always open for proposal
