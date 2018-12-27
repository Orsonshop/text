package design;
import java.util.List;
import java.util.ArrayList;


enum ChannelTypeEnum{
    ENGLISH,FRANCH,CHINESE,HINDI,ALL
}

class Channel{
    public Channel(double frequency, ChannelTypeEnum type) {
        this.frequency = frequency;
        this.type = type;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getType() {
        return type;
    }


    private double frequency;
    private ChannelTypeEnum type;

    @Override
    public String toString() {
        return "frequency="+this.frequency+"channel="+this.type;
    }
}
interface ChannelCollection{
    void addChannel(Channel c);
    void removeChannel(Channel c);

    ChannelIterator iterator(ChannelTypeEnum type);
}
interface ChannelIterator{
    boolean hasNext();
    Channel next();
}
class ChannelCollectionImpl implements ChannelCollection{
    private List<Channel>channelList;

    public ChannelCollectionImpl() {
        this.channelList = new ArrayList <>();
    }

    @Override
    public void addChannel(Channel c) {
        this.channelList.add(c);
    }

    @Override
    public void removeChannel(Channel c) {
        this.channelList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type,this.channelList);
    }


    private class ChannelIteratorImpl implements ChannelIterator{
        private ChannelTypeEnum type;
        private List<Channel>channels;
        private int position;

        public ChannelIteratorImpl(ChannelTypeEnum type,List<Channel>channels) {
            this.type=type;
            this.channels=channels;
        }

        @Override
        public boolean hasNext() {
            while(position<channels.size()){

                Channel c=channels.get(position);
                if (c.getType().equals(type)||type.equals(ChannelTypeEnum.ALL)) {
                    return true;
                }else {
                    position++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c=channels.get(position);
            position++;
            return c;
        }
    }
}



public class RadioChannel {
    public static void main(String[] args) {
        ChannelCollection channels=populateChannels();
        System.out.println("***********");
        ChannelIterator chineseIterator=channels.iterator(ChannelTypeEnum.CHINESE);
        while(chineseIterator.hasNext()){
            System.out.println(chineseIterator.next().toString());
        }
        System.out.println("**********");
        ChannelIterator chineseIterator1=channels.iterator(ChannelTypeEnum.ALL);
        while(chineseIterator1.hasNext()){
            System.out.println(chineseIterator1.next().toString());
        }
    }
    private static ChannelCollection populateChannels(){
        ChannelCollection channels=new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5,ChannelTypeEnum.CHINESE));
        channels.addChannel(new Channel(87.3,ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(93,ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(95,ChannelTypeEnum.HINDI));
        return channels;
    }
}