package distributedsystems;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class TokenBucketRateLimiting {

	public static void main(String[] args) {
		TokenBucketFilter tokenBucketFilter = new TokenBucketFilter();
		List<Thread> allThreads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						tokenBucketFilter.getToken();
					}
				}
			};
			t.setName("Thread:" + i + " ");
			allThreads.add(t);
		}
		for (Thread t : allThreads) {
			t.start();
		}

	}

}

class TokenBucketFilter {
	final int MAX_TOKENS = 60;
	int availableTokens;
	long lastRefillTime;
	long nextRefillTime;

	TokenBucketFilter() {
		refill();
	}

	public synchronized void getToken() {
		refill();
		if (availableTokens == 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("status code: 429");
			return;
		}
		availableTokens--;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("available tokens: " + availableTokens);
		System.out.println(Thread.currentThread().getName() + " Consumed the token at: " + localDateTime);
	}

	private void refill() {
		long currentTime = System.currentTimeMillis();
		if (currentTime < nextRefillTime) {
			return;
		}
		availableTokens = availableTokens + ((int) ((currentTime - lastRefillTime) / 1000));
		if (availableTokens > MAX_TOKENS) {
			availableTokens = MAX_TOKENS;
		}
		lastRefillTime = currentTime;
		nextRefillTime = currentTime + 1000;
	}
}
