package com.phuongsala.weatherforecast.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.phuongsala.weatherforecast.common.OnItemClickListener
import com.phuongsala.weatherforecast.common.ViewHolderFactory

abstract class BaseAdapter<T : BaseItemModel> : RecyclerView.Adapter<BaseViewHolder>() {

    private var sourceData = ArrayList<T>()

    protected var onItemClickListener: OnItemClickListener? = null

    protected abstract fun getDiffItem() : DiffUtil.ItemCallback<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ViewHolderFactory.createViewHolder(parent, viewType, onItemClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        holder.unbind()
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int {
        return sourceData.size
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).hashCode().toLong()
    }

    open fun setData(data: List<T>) {
        val newList = ArrayList(data)
        submit(newList)
    }

    fun getItem(position: Int): T {
        return sourceData[position]
    }

    fun addItems(items: List<T>) {
        if (sourceData.isEmpty()) {
            setData(items)
        } else {
            sourceData.addAll(items)
            notifyItemRangeInserted(itemCount, items.size)
        }
    }

    fun refreshData() {
        val newList = ArrayList(sourceData)
        submit(newList)
    }

    fun clearAll() {
        submit(arrayListOf())
    }

    fun getData(): List<T> {
        return sourceData
    }

    fun appendItem(item: T) {

        this.sourceData.add(item)
        notifyItemInserted(itemCount)
    }

    fun appendItemPosition(item: T, position: Int) {
        if (this.sourceData.isEmpty() || position < 0 || position > this.sourceData.size) {
            return
        }
        this.sourceData.add(position, item)
        notifyItemInserted(position)
    }

    fun updateItem(position: Int, item: T) {
        if (this.sourceData.size > position) {
            sourceData[position] = item
            notifyItemChanged(position)
        }
    }

    fun removeAtPosition(position: Int) {
        if (position >= 0 && this.sourceData.size > position) {
            sourceData.removeAt(position)
            notifyItemRangeRemoved(position, 1)
        }
    }

    fun removeItem(item: T) {
        val position = sourceData.indexOf(item)
        if (position > -1) {
            sourceData.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun appendItems(items: List<T>) {
        if (sourceData.isEmpty()) {
            setData(items)
        } else {
            sourceData.addAll(items)
            notifyItemRangeInserted(itemCount, items.size)
        }
    }

    fun insertItems(position: Int, items: List<T>) {
        if (sourceData.isEmpty()) {
            setData(items)
        } else {
            sourceData.addAll(position, items)
            notifyItemRangeInserted(position, items.size)
        }
    }

    private fun submit(items: List<T>) {
        autoNotify(sourceData, items)
    }

    private fun autoNotify(old: List<T>, new: List<T>) {

        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = old[oldItemPosition]
                val newItem = new[newItemPosition]
                return getDiffItem().areItemsTheSame(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = old[oldItemPosition]
                val newItem = new[newItemPosition]
                return getDiffItem().areContentsTheSame(oldItem, newItem)
            }

            override fun getOldListSize() = old.size

            override fun getNewListSize() = new.size
        })

        sourceData.clear()
        sourceData.addAll(new)

        diff.dispatchUpdatesTo(this)
    }

}