import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KarmicPoints extends Command {


    public KarmicPoints()
    {

        this.name = "Karma";
        this.aliases = new String[] {"deeds", "points"};
        this.help = "Your karma.";



    }

    @Override
    protected void execute(CommandEvent event) {






    }




    public static <K,V> Map<K,V> map(Collection<K> keys, Collection<V> values) {

        Map<K,V> map = new HashMap<>();
        Iterator<K> keyIt = keys.iterator();
        Iterator<V> valueIt = values.iterator();
        while(keyIt.hasNext() && valueIt.hasNext()) {
            K k = keyIt.next();
            if (null != map.put(k, valueIt.next())){
                throw new IllegalArgumentException("Keys are not unique! Key " + k + " found more then once.");
            }
        }
        if (keyIt.hasNext() || valueIt.hasNext()) {
            throw new IllegalArgumentException("Keys and values collections have not the same size");
        };

        return map;


    }


    private long getUsersInGuild(Guild guild) {
        return guild.getMembers().stream().filter(member -> !member.getUser().isBot()).count();
    }




}
