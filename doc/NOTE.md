# Chapter 2

## Java thread state
![Thread State Machine](thread_state_machine.png)
Compared to WAITING, TIMED_WAITING means wait for a period of time.

## Start and Stop a thread
To start a thread:
1. Implement a Runnable interface.
1. Add parallel code in run method.
1. Pass in Runnable class into Thread class constructor.
1. Get new thread object and call `start()` method.

Don't call `stop()` method in thread object. It may force releasing lock in an unexpected way that causes inconsistent state of object. It may also cause resource leak.
