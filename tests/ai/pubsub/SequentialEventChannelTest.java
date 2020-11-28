package ai.pubsub;

import org.junit.jupiter.api.Test;

import ai.domain.Card;
import ai.statistic.FakeStatistic;
import ai.statistic.StatisticEvent;

class SequentialEventChannelTest {

	@Test
    public void testPublishDataWithSubscriber() throws Exception {
        SequentialEventChannel sequentialEventChannel = new SequentialEventChannel();
        FakeStatistic statistic = new FakeStatistic();
        sequentialEventChannel.subscribe(statistic);
        StatisticEvent statisticEvent = new StatisticEvent(new Card("",""), 0, 1);
        sequentialEventChannel.publish(statisticEvent);
        statistic.verifyReceiveUpdateDataFor(statisticEvent);
    }
}
