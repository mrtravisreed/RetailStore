public interface IStockItem {

  /**
   * Checks if there is enough stock to make a purchase of a given size.
   *
   * @param purchaseAmount the amount to purchase
   * @return true if there is sufficient quantity to purchase, false if not
   */
  boolean isEnough(int purchaseAmount);

  /**
   * Performs a purchase of a given amount, updating the quantity available.
   *
   * @param purchaseAmount the amount to purchase
   * @throws NotEnoughProductException if there is not sufficient quantity to purchase
   */
  void purchase(int purchaseAmount) throws NotEnoughProductException;
}
