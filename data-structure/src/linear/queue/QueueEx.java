package linear.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

    private final static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        // offer은 queue에 값 넣기
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // poll은 넣은 순서대로 출력 (FIFO)
        }
    }
}
