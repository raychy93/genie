import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

public class Identity extends Command {


    public Identity()
    {

        this.name = "reset";
        this.aliases = new String[] {"username, myName"};
        this.help = "Change back to original names";

    }

    @Override
    protected void execute(CommandEvent event) {

        event.getGuild().getManager().setName("Neo Kemet"+" \uD80C\uDD8E\uD80C\uDD53\uD80C\uDFCF\uD80C\uDE96");

        event.getMessage().getContentRaw().equalsIgnoreCase("$reset");

        if(event.getMessage().getMember().hasPermission(Permission.NICKNAME_MANAGE)) {
            event.getGuild().loadMembers().onSuccess(members -> {

                for (Member member : members) {

                    if(!member.isOwner()) {
                        event.getGuild().modifyNickname(member, member.getUser().getName()).queue();
                    }
                }

            });
        }




    }



}
