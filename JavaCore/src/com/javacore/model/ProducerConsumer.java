package com.javacore.model;

public class ProducerConsumer {

	private static Object lock = new Object();

	private static int[] buffer;

	private static int count;

	static class Producer{
		public void produce() {
			synchronized (lock) {
				if(isFull(buffer)) 
				{ 
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notifyAll();
			}
		}
	}

	static class Consumer{
		public void consume() {

			synchronized (lock) {
				if(isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				lock.notifyAll();
			}

		}
	}

	static boolean isEmpty(int[] buffer) {
		return (count == 0);
	}

	static boolean isFull(int[] buffer) {
		return (count == buffer.length);
	}


	public static void main(String args[]) throws InterruptedException {
		buffer = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable produceTask = () -> {
			for (int i=0; i<50; i++)
				producer.produce();

			System.out.println("Done Producing: ");
		};

		Runnable consumeTask = () -> {
			for (int i=0; i<40; i++)
				consumer.consume();

			System.out.println("Done Consuming: ");
		};


		Thread producingThread = new Thread(produceTask);
		Thread consumingThread = new Thread(consumeTask);

		consumingThread.start();
		producingThread.start();

		consumingThread.join();
		producingThread.join();

		System.out.println("Data in the buffer: "+count);

	}
}
