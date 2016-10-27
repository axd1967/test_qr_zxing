This is a dummy ZXing Android integration test project.

It opens a simple activity with an embedded fragment that contains a button that triggers a scan via `IntentIntegrator`.

The problem is that the approach does not work: see also https://github.com/zxing/zxing/issues/291#issuecomment-256594778

Also, the QR (provided in the root directory) does not decode.

All this gioves the impression that the Android part is not very mature.