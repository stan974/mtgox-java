package to.sparks.mtgox.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author SparksG
 */
@JsonAutoDetect
public class TradeResult extends DtoBase implements CurrencyKludge {

    private String trade_id;
    private String primary;
    private String type;
    private String properties;
    private String item;
    private TickerPrice amount;
    private TickerPrice price;
    private TickerPrice spent;
    private String date;

    public TradeResult(@JsonProperty("trade_id") String trade_id,
            @JsonProperty("primary") String primary,
            @JsonProperty("currency") String currency,
            @JsonProperty("type") String type,
            @JsonProperty("properties") String properties,
            @JsonProperty("item") String item,
            @JsonProperty("amount") TickerPrice amount,
            @JsonProperty("price") TickerPrice price,
            @JsonProperty("spent") TickerPrice spent,
            @JsonProperty("date") String date) {
        this.trade_id = trade_id;
        this.primary = primary;
        this.type = type;
        this.properties = properties;
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.spent = spent;
        this.date = date;

        if (this.amount != null) {
            this.amount.setCurrencyInfo(CurrencyInfo.BitcoinCurrencyInfo);
        }
    }

    @Override
    public void setCurrencyInfo(CurrencyInfo currencyInfo) {
        price.setCurrencyInfo(currencyInfo);
        spent.setCurrencyInfo(currencyInfo);
    }

    /**
     * @return the trade_id
     */
    public String getTradeId() {
        return trade_id;
    }

    /**
     * @return the primary
     */
    public String getPrimary() {
        return primary;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the properties
     */
    public String getProperties() {
        return properties;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @return the amount
     */
    public TickerPrice getAmount() {
        return amount;
    }

    /**
     * @return the price
     */
    public TickerPrice getPrice() {
        return price;
    }

    /**
     * @return the spent
     */
    public TickerPrice getSpent() {
        return spent;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
}
