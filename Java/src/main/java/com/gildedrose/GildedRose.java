package com.gildedrose;
import java.util.Arrays;
public class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateItem);
    }
    private void updateItem(Item item) {
        if (isNormalItem(item)) updateNormalItem(item);
        else if (isAgedBrie(item)) updateAgedBrie(item);
        else if (isBackstagePass(item)) updateBackstagePass(item);


        if (!isSulfuras(item)) decrementSellIn(item);

        if (item.sellIn < 0) handleExpiredItem(item);
    }
    private boolean isNormalItem(Item item) {
        return !isAgedBrie(item) && !isBackstagePass(item) && !isSulfuras(item);
    }
    private boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.name);
    }
    private boolean isBackstagePass(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }
    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0 && !isSulfuras(item))
            item.quality--;

    }
    private void updateAgedBrie(Item item) {
        if (item.quality < 50) item.quality++;
    }

    private void updateBackstagePass(Item item){
        if (item.quality < 50) item.quality++;
        if (item.sellIn < 11 && item.quality < 50) item.quality++;
        if (item.sellIn < 6 && item.quality < 50) item.quality++;
    }
    private void decrementSellIn(Item item) {
        item.sellIn--;}
    private void handleExpiredItem(Item item) {
        if (isNormalItem(item) && item.quality > 0 && !isSulfuras(item)) item.quality--;
        else if (isBackstagePass(item)) item.quality = 0;
        else if (isAgedBrie(item) && item.quality < 50) item.quality++;
    }
}
