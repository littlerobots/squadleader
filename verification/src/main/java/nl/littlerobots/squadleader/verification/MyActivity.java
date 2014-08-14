package nl.littlerobots.squadleader.verification;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

import butterknife.InjectView;
import butterknife.OnClick;
import nl.littlerobots.squadleader.Keep;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        // need a reference because otherwise ProGuard will strip out KeepFieldsTester
        KeepFieldsTester object = new KeepFieldsTester();
    }

    @Subscribe
    public void testOttoSubscribeAnnotation() {

    }

    @Produce
    public void testOttoProduceAnnotation() {

    }

    @Keep
    public void testKeepMethod() {
    }

    static final class ButterknifeTarget {
        @InjectView(R.id.test)
        View mTestView;

        @OnClick(R.id.test)
        public void testAction() {

        }
    }

    static final class DummyJavaScriptInterface {
        @JavascriptInterface
        public void dummyJsMethod() {

        }
    }

}
