

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;


public class ServerDetails extends Command {


    public ServerDetails(){
        this.name = "kemetinfo";
        this.aliases = new String[] {"server"};
        this.help = "Gives information about the server.";


    }

    @Override
    protected void execute(CommandEvent event) {

        String[] members = new String[event.getGuild().getMembers().size()];
        for(int i=0; i<event.getGuild().getMembers().size();i++){
            members[i] = event.getGuild().getMembers().get(i).getEffectiveName();
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setAuthor(event.getGuild().getName());
        eb.setThumbnail("https://static.thenounproject.com/png/1954810-200.png");
        //eb.addField("Server Owner:", event.getGuild().getOwner().getNickname(),true);
        eb.addField("Member Count:" , Integer.toString(event.getGuild().getMembers().size()), true);
        eb.setDescription("**Members:** \n" + Arrays.toString(members) + "\n **Invite Link:** \n  https://discord.gg/b9Z2B2NNyc");

        event.getChannel().sendMessage(eb.build()).queue();

    }
}
