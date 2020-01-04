package com.fuyd;

import org.junit.Test;

import java.util.List;

public class RedPacketTest {
    @Test
    public void testSplitRedPacket() {
        RedPacket redPacket = new RedPacket();
        List<Integer> redPackets = redPacket.splitRedPacket(20000, 100);
        System.out.println(redPackets);

        int sum = 0;
        for (Integer red : redPackets) {
            sum += red;
        }
        System.out.println(sum);
    }
}
