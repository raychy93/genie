

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


public class ChangeNick extends Command{

    public ChangeNick()
    {

        this.name = "Reincarnate";
        this.aliases = new String[] {"rebirth", "samsara"};
        this.help = "Kemet Reborn";



    }






    @Override
    protected void execute(CommandEvent event) {

        event.getMessage().getContentRaw().equalsIgnoreCase("$reincarnate");
        if(event.getMessage().getMember().hasPermission(Permission.NICKNAME_MANAGE)) {
            event.getGuild().loadMembers().onSuccess(members -> {
                for (Member member : members) {

                    event.getGuild().modifyNickname(member, "\uD80D\uDC2E\uD80C\uDC76\uD80C\uDD02\uD80C\uDD53\uD80C\uDD12\uD80C\uDC87\uD80C\uDFDC").queue();
                    event.getGuild().modifyNickname(member,event.getGuild().getName());
                }

            });
        }




    }
}
