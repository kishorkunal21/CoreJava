package com.udemy.java.concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLock {

	public static void main(String[] args) {
		PriceContainer priceContainer = new PriceContainer();
		PriceUpdater priceUpdater = new PriceUpdater(priceContainer);
		UIThread uIThread = new UIThread(priceContainer);
		priceUpdater.start();
		uIThread.start();

	}

	private static class UIThread extends Thread {

		PriceContainer priceContainer;

		public UIThread(PriceContainer priceContainer) {
			this.priceContainer = priceContainer;
		}

		@Override
		public void run() {
			try {

				while (true) {
					Thread.sleep(2000);
					if (priceContainer.getLockObject().tryLock()) {

						System.out.println("BitcoinPrice =>" + priceContainer.getBitcoinPrice());
						System.out.println("EtherPrice =>" + priceContainer.getEtherPrice());
						System.out.println("LitecoinPrice =>" + priceContainer.getLitecoinPrice());
						System.out.println("BitcoinCashPrice =>" + priceContainer.getBitcoinCashPrice());
						System.out.println("RipplePrice =>" + priceContainer.getRipplePrice());

						System.out.println("\n##########################\n");

					}
					priceContainer.getLockObject().unlock();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {

			}

		}

	}

	private static class PriceUpdater extends Thread {
		private PriceContainer priceContainer;
		Random random = new Random();

		public PriceUpdater(PriceContainer priceContainer) {
			this.priceContainer = priceContainer;
		}

		@Override
		public void run() {
			// System.out.println("Inside PriceUpdater");

			try {
				while (true) {
					Thread.sleep(1000);
					if (priceContainer.getLockObject().tryLock()) {
						// System.out.println("UPdating :" + random.nextDouble());
						priceContainer.setBitcoinCashPrice(random.nextDouble());
						priceContainer.setBitcoinPrice(random.nextDouble());
						priceContainer.setEtherPrice(random.nextDouble());
						priceContainer.setLitecoinPrice(random.nextDouble());
						priceContainer.setRipplePrice(random.nextDouble());
						priceContainer.lockObject.unlock();
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {

			}
		}
	}

	private static class PriceContainer {

		private Lock lockObject = new ReentrantLock();
		private double bitcoinPrice;
		private double etherPrice;
		private double litecoinPrice;
		private double bitcoinCashPrice;
		private double ripplePrice;

		public Lock getLockObject() {
			return lockObject;
		}

		public void setLockObject(Lock lockObject) {
			this.lockObject = lockObject;
		}

		public double getBitcoinPrice() {
			return bitcoinPrice;
		}

		public void setBitcoinPrice(double bitcoinPrice) {
			this.bitcoinPrice = bitcoinPrice;
		}

		public double getEtherPrice() {
			return etherPrice;
		}

		public void setEtherPrice(double etherPrice) {
			this.etherPrice = etherPrice;
		}

		public double getLitecoinPrice() {
			return litecoinPrice;
		}

		public void setLitecoinPrice(double litecoinPrice) {
			this.litecoinPrice = litecoinPrice;
		}

		public double getBitcoinCashPrice() {
			return bitcoinCashPrice;
		}

		public void setBitcoinCashPrice(double bitcoinCashPrice) {
			this.bitcoinCashPrice = bitcoinCashPrice;
		}

		public double getRipplePrice() {
			return ripplePrice;
		}

		public void setRipplePrice(double ripplePrice) {
			this.ripplePrice = ripplePrice;
		}

	}

}
