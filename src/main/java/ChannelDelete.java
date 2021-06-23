

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.WidgetUtil;
import net.dv8tion.jda.api.utils.concurrent.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChannelDelete extends Command {

    public ChannelDelete()
    {

        this.name = "Hakai";
        this.aliases = new String[] {"perish", "destroy"};
        this.help = "banishment of any channel in the server";



    }










    @Override
    protected void execute(CommandEvent event) {
        Member Malek = event.getGuild().getMemberById("689637787414429696");

        event.getMessage().getContentRaw().equalsIgnoreCase("$hakai");
        if (event.getMessage().getMember().equals(Malek)) {

            for (int i = 0; i < event.getGuild().getChannels().size(); i++) {
                event.getGuild().getChannels().get(i).delete().queue();

            }
        }
        else {
            event.getChannel().sendMessage("You have attempted to invoke destruction. Permission denied.").queue();
            event.getMessage().getMember().modifyNickname("The Fool").queue();
            event.getGuild().addRoleToMember(event.getMessage().getMember(), event.getGuild().getRoleById("812826397537075231")).queue();
            event.getGuild().removeRoleFromMember(event.getMessage().getMember(),event.getGuild().getRoleById("812826397537075237")).queue();
        }
    }

    }

