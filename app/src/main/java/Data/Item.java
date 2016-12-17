package Data;

/**
 * Created by Guanzhu Li on 12/17/2016.
 */
public  class Item {
    private final String mItemID;
    private final String mItemName;
    private final double mPrice;
    private final String mLength;
    private final String mWidth;
    private final String mDescription;
    private final String mDesigner;
    private final String mImage;
    private final String mCategory;
    private Item(ItemBuilder builder) {
        this.mItemID = builder.mItemId;
        this.mItemName = builder.mItemName;
        this.mCategory = builder.mCategory;
        this.mPrice = builder.mPrice;
        this.mLength = builder.mLength;
        this.mWidth = builder.mWidth;
        this.mImage = builder.mImage;
        this.mDescription = builder.mDescription;
        this.mDesigner = builder.mDesigner;
    }
    public String getItemID() {
        return mItemID;
    }
    public String getItemName() {
        return mItemName;
    }
    public double getPrice() {
        return mPrice;
    }
    public String getLength() {
        return mLength;
    }
    public String getWidth() {
        return mWidth;
    }
    public String getDescription() {
        return mDescription;
    }
    public String getDesigner() {
        return mDesigner;
    }
    public String getImage() {
        return mImage;
    }
    public String getCategory() {
        return mCategory;
    }
    public static class ItemBuilder {
        private final String mItemId;
        private final String mItemName;
        private final double mPrice;
        private String mLength;
        private String mWidth;
        private String mDescription;
        private String mDesigner;
        private final String mImage;
        private final String mCategory;
        public ItemBuilder(String itemId, String itemName, String image, String category, double price) {
            this.mItemId = itemId;
            this.mItemName = itemName;
            this.mImage = image;
            this.mCategory = category;
            this.mPrice = price;
        }

        public ItemBuilder length(String length) {
            this.mLength = length;
            return this;
        }
        public ItemBuilder width(String width) {
            this.mWidth = width;
            return this;
        }
        public ItemBuilder discription(String discription) {
            this.mDescription = discription;
            return this;
        }
        public ItemBuilder designer(String designer) {
            this.mDesigner = designer;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
    }
}
