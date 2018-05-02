package farshid_roohi.ir.customrecyclerview.view.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.adapter.ItemContainerAdapter;

public class ItemContainerView extends LinearLayout {

    private ItemContainerAdapter containerAdapter;

    public ItemContainerView(Context context) {
        super(context);
        this.initializeView();
    }

    public ItemContainerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initializeView();
    }

    public ItemContainerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initializeView();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.initializeView();
    }

    public void setParents(List<ItemParentView> values) {
        this.containerAdapter.putItems(values);
        this.containerAdapter.notifyDataSetChanged();
    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_container, this, true);

        RecyclerView recyclerContainer = view.findViewById(R.id.recycler_container);
        recyclerContainer.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.containerAdapter = new ItemContainerAdapter(getContext());
        recyclerContainer.setAdapter(this.containerAdapter);

    }
}