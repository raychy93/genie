import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.List;

public class Disguise extends Command {


    public Disguise()
    {

        this.name = "\uD80C\uDDCB\uD80C\uDD71\uD80C\uDC8B\uD80D\uDC0D\uD80C\uDFDC\uD80C\uDFA1\uD80C\uDD71\uD80C\uDEF4\uD80C\uDE19\uD80C\uDFCF\uD80C\uDF54\uD80C\uDE16\n";
        this.aliases = new String[] {"disguise"};
        this.help = "Kemet Hidden";



    }

    @Override
    protected void execute(CommandEvent event) {


        event.getGuild().getCategoryById("842239837213425694").getManager().setName("\uD80C\uDD53\uD80C\uDD8E\uD80C\uDD53\uD80C\uDFCF\uD80C\uDE96").queue();
        event.getGuild().getCategoryById("842239993098534932").getManager().setName("\uD80C\uDF70\uD80C\uDD1F\uD80C\uDD10\uD80C\uDCA1\uD80C\uDFE6\uD80C\uDFE7").queue();
        event.getGuild().getCategoryById("842246179244343306").getManager().setName("\uD80C\uDEE2\uD80C\uDDDA\uD80C\uDF44\uD80C\uDCA1\uD80C\uDDFC\uD80C\uDF24\uD80C\uDF49").queue();
        event.getGuild().getCategoryById("842242232857264138").getManager().setName("\uD80C\uDF5C\uD80C\uDF3D\uD80C\uDF35\uD80C\uDF3A\uD80C\uDEDA\uD80C\uDE82").queue();
        event.getGuild().getCategoryById("842245655804379147").getManager().setName("\uD80C\uDEE7\uD80C\uDEC6\uD80C\uDEAB\uD80C\uDEA6\uD80C\uDE99\uD80C\uDE8F").queue();
        event.getGuild().getCategoryById("842240363162370078").getManager().setName("\uD80C\uDC42\uD80C\uDC40\uD80C\uDCD1\uD80C\uDCFC\uD80C\uDDBC").queue();
        event.getGuild().getCategoryById("842249424080338995").getManager().setName("\uD80C\uDF77\uD80C\uDF82\uD80C\uDFAC\uD80C\uDFCE\uD80C\uDF78\uD80C\uDFEB\uD80C\uDFEC\uD80C\uDFF0").queue();

        event.getGuild().getTextChannelById("842238760216821770").getManager().setName("\uD80C\uDD53\uD80C\uDD8E\uD80C\uDD53\uD80C\uDFCF\uD80C\uDE96").queue();
            event.getGuild().getTextChannelById("842239434245144617").getManager().setName("\uD80C\uDF70\uD80C\uDD1F\uD80C\uDD10\uD80C\uDCA1\uD80C\uDFE6\uD80C\uDFE7").queue();
            event.getGuild().getTextChannelById("842265107815202816").getManager().setName("\uD80C\uDEE2\uD80C\uDEBF\uD80C\uDE8A\uD80C\uDCA1\uD80C\uDEAF\uD80C\uDFE6\uD80C\uDFE7").queue();
            event.getGuild().getTextChannelById("842239479820582912").getManager().setName("\uD80C\uDEE2\uD80C\uDDDA\uD80C\uDF44\uD80C\uDCA1\uD80C\uDDFC\uD80C\uDF24\uD80C\uDF49").queue();
            event.getGuild().getTextChannelById("842247403428118558").getManager().setName("\uD80C\uDF77\uD80C\uDF82\uD80C\uDFAC\uD80C\uDFCE\uD80C\uDF78\uD80C\uDFEB\uD80C\uDFEC\uD80C\uDFF0").queue();
            event.getGuild().getTextChannelById("842239651031941120").getManager().setName("\uD80C\uDFB4\uD80C\uDF6E\uD80C\uDFED\uD80C\uDFEE\uD80C\uDFCE\uD80C\uDF78\uD80C\uDFEB\uD80C\uDFEC\uD80C\uDFF0").queue();
            event.getGuild().getTextChannelById("842265472073728041").getManager().setName("\uD80C\uDEE7\uD80C\uDEC6\uD80C\uDEAB\uD80C\uDEA6\uD80C\uDE99\uD80C\uDE8F").queue();
            event.getGuild().getTextChannelById("842239622976765952").getManager().setName("\uD80C\uDEAE\uD80C\uDED3\uD80C\uDEF6\uD80C\uDF05\uD80C\uDFF7\uD80C\uDFF8\uD80C\uDF26\uD80C\uDF56\uD80C\uDF57").queue();
            event.getGuild().getTextChannelById("842239603402211368").getManager().setName("\uD80C\uDF5C\uD80C\uDF3D\uD80C\uDF35\uD80C\uDF3A\uD80C\uDEDA\uD80C\uDE82").queue();
            event.getGuild().getTextChannelById("842247417893879809").getManager().setName("\uD80C\uDE5A\uD80C\uDE11\uD80C\uDE12\uD80C\uDE17\uD80C\uDDF1\uD80C\uDD6F\uD80C\uDD4C\uD80C\uDD3D").queue();
            event.getGuild().getTextChannelById("842240668491317269").getManager().setName("\uD80C\uDD21\uD80C\uDD22\uD80C\uDD02\uD80C\uDCE9\uD80C\uDCBC\uD80C\uDCBD\uD80C\uDC90").queue();
            event.getGuild().getTextChannelById("842239571429425172").getManager().setName("\uD80C\uDC42\uD80C\uDC40\uD80C\uDCD1\uD80C\uDCFC\uD80C\uDDBC").queue();
            event.getGuild().getTextChannelById("842239521227931659").getManager().setName("\uD80C\uDE1B\uD80C\uDE1E\uD80C\uDE34\uD80C\uDE51\uD80C\uDE84\uD80C\uDF45\uD80C\uDFEC\uD80C\uDFED").queue();
            event.getGuild().getTextChannelById("842248572229255220").getManager().setName("\uD80C\uDFF5\uD80C\uDFF0\uD80C\uDC80\uD80C\uDFF1\uD80C\uDF9C\uD80C\uDF7C\uD80C\uDF6D\uD80C\uDC84").queue();
            event.getGuild().getTextChannelById("842248881776623656").getManager().setName("\uD80C\uDCF9\uD80C\uDD30\uD80C\uDD32\uD80C\uDD22\uD80C\uDD54\uD80C\uDD8C\uD80C\uDDBB").queue();
            event.getGuild().getTextChannelById("842249881342312458").getManager().setName("\uD80C\uDCF9\uD80C\uDD30\uD80C\uDD32\uD80C\uDD22\uD80C\uDD54\uD80C\uDD8C\uD80C\uDDBB").queue();
            event.getGuild().getTextChannelById("842251090116476928").getManager().setName("\uD80C\uDCF9\uD80C\uDD30\uD80C\uDD32\uD80C\uDD22\uD80C\uDD54\uD80C\uDD8C\uD80C\uDDBB").queue();

        event.getGuild().getVoiceChannelById("842239758196801542").getManager().setName("\uD80C\uDDB2").queue();
            event.getGuild().getVoiceChannelById("842239726001586196").getManager().setName("\uD80C\uDDB2\uD80C\uDDB2").queue();
            //event.getGuild().getVoiceChannelById("828753097936732240").getManager().setName("\uD80C\uDDB2\uD80C\uDDB2\uD80C\uDDB2").queue();

//
        }



}
