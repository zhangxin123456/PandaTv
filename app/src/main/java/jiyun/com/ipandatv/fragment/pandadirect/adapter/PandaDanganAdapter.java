package jiyun.com.ipandatv.fragment.pandadirect.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import jiyun.com.ipandatv.App;
import jiyun.com.ipandatv.R;
import jiyun.com.ipandatv.activity.VideoActivity;
import jiyun.com.ipandatv.fragment.pandadirect.bean.PandaDanganBean;
import jiyun.com.ipandatv.utils.MyLog;

/**
 * Created by INS7566 on 2017/7/14.
 */

public class PandaDanganAdapter extends BaseAdapter<PandaDanganBean.VideoBean> {
    public PandaDanganAdapter(Context context, List<PandaDanganBean.VideoBean> datas) {
        super(context, R.layout.adapter_jcyk, datas);
    }

    @Override
    public void convert(final ViewHolder holder, final PandaDanganBean.VideoBean bean) {
        holder.setText(R.id.panda_oculture_item_sp_time, bean.getLen())
                .setText(R.id.panda_culture_item_title, bean.getT())
                .setText(R.id.panda_culture_item_time, bean.getPtime());
        ImageView imageView = holder.getView(R.id.panda_culture_item_image);
        Glide.with(context).load(bean.getImg()).into(imageView);
        holder.setOnclickListener(R.id.culture_relat, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,VideoActivity.class);
                intent.putExtra("url","http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/07/06/24a1ae38737c44a2a211babb3c6dee3d_h264418000nero_aac32-1.mp4");
                intent.putExtra("title",bean.getT());
                intent.putExtra("pid",bean.getVid());
                MyLog.e("Url",bean.getUrl()+bean.getT());
                App.activity.startActivity(intent);
            }
        });
    }
}
