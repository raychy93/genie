import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

public class Babz extends Command {


    public Babz(){


        this.name = "babz";
        this.aliases = new String[] {"akadz"};
        this.help = "Citizens of Babylon ";


    }

    @Override
    protected void execute(CommandEvent event) {

        event.getMessage().getContentRaw().equalsIgnoreCase("$babz");
        if(event.getMessage().getMember().hasPermission(Permission.NICKNAME_MANAGE)) {
            event.getGuild().loadMembers().onSuccess(members -> {
                for (Member member : members) {

                    event.getGuild().modifyNickname(member, "\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();

                }

            });
        }




    }



//







}
