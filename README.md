# AsynchronousProcessingSample

## Processing of this app
1. The app starts
2. ViewText is executed in SlowProcessClass (slow processing-> asynchronous processing)
3. The screen is displayed (do not wait for the result of processing 2)
4. WebView is loaded (do not wait for the result of processing 2)
