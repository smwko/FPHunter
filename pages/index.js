import Head from 'next/head'
import Header from '@components/Header'
import Footer from '@components/Footer'

export default function Home() {
  return (
    <div className="container">

    <Head>
        <title>FPHunter</title>
        <link rel="icon" href="/favicon.ico" />
        <img src="/Logo FPHunter.jpg" width="100" height="100" />
    </Head>

    <main>
        <Header title="Introduccion" />
        <p className="description">
            Cazadores de Formación Profesional
        </p>
        <p align="left"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla interdum hendrerit dignissim. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce ultricies ex nulla, vel congue tortor rutrum non. Phasellus a augue tortor. Morbi molestie augue id consectetur tristique. Quisque vitae leo mauris. Curabitur ut eros magna. Ut lectus ligula, commodo non faucibus quis, dictum ut nisl. Duis vel sem sapien. Maecenas vitae lorem eleifend, volutpat turpis sed, imperdiet eros. Aenean fringilla, neque sed gravida maximus, risus enim elementum diam, vel viverra nisi elit et ipsum. Mauris ut lacus accumsan, interdum mi vitae, suscipit risus.

            Aenean facilisis nibh at ornare bibendum. Nam malesuada feugiat elit in vestibulum. Donec auctor lorem lorem, eu blandit risus sollicitudin non. Vivamus consectetur feugiat est quis vestibulum. Curabitur ante est, facilisis sed velit in, congue lacinia mauris. Sed ultricies sapien sed mattis tincidunt. Phasellus ac velit purus. Sed molestie ligula sed interdum gravida. Fusce ac nisi auctor, molestie velit ac, tincidunt lorem. Integer volutpat pretium maximus. Pellentesque dui urna, eleifend eget lacus at, molestie commodo eros. Nunc suscipit, neque ut aliquam luctus, nunc lorem rutrum dui, ac interdum nisl neque in justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam id sem non velit molestie blandit. Nulla convallis urna quis nulla ullamcorper tristique.
            
            Vestibulum volutpat urna est, in fermentum mi laoreet ac. Phasellus mattis nisl ut ipsum feugiat, id sollicitudin elit ultrices. Fusce ac lectus aliquam, mattis dolor ac, auctor est. Aliquam fringilla mauris et bibendum bibendum. Sed volutpat efficitur lacus, sed interdum nunc blandit eu. Praesent hendrerit, massa a condimentum luctus, risus dui vehicula metus, a porttitor diam turpis id diam. Sed non tellus ac justo pellentesque tempor sit amet eget dolor. Fusce elementum, augue quis varius commodo, nisl augue commodo lacus, sit amet venenatis purus nisi sit amet neque. Curabitur eu urna blandit, faucibus est vel, tempus tortor. Nulla placerat vehicula erat, at ultricies ligula aliquet non. Mauris fermentum nunc vitae velit condimentum vestibulum. Praesent vitae hendrerit neque, eu ullamcorper ipsum. Duis vulputate mauris vitae mauris hendrerit, quis vehicula libero consectetur. Pellentesque consequat tincidunt orci. Proin luctus, risus eu suscipit tempor, ex lorem vulputate lacus, sollicitudin semper tortor libero quis felis.
            
            Maecenas nisi arcu, tristique id dui a, ultricies vehicula nulla. Aenean quis justo sagittis, fermentum sapien sit amet, rhoncus lacus. Nam faucibus, mi non dictum convallis, orci odio convallis elit, eget euismod justo libero et mi. Fusce bibendum imperdiet augue vitae porta. Morbi facilisis dui quis nulla dignissim, vel bibendum elit mollis. Quisque feugiat cursus urna ut rhoncus. Cras aliquam diam id laoreet tempus. In velit quam, consequat vitae velit et, consequat porta lectus. Praesent mauris dui, semper sed sollicitudin eget, suscipit sed nulla. Quisque pulvinar ac dui in ultrices. Aliquam tincidunt aliquam diam vitae malesuada.
            
            Nunc lorem mi, varius at bibendum nec, efficitur in ante. Praesent sit amet gravida elit. Vivamus eget augue ipsum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Fusce euismod erat id mauris faucibus, eu dictum dui tincidunt. Aliquam ultrices ligula sed nisi rutrum, et tempor ligula efficitur. Mauris non lacinia ex. Vestibulum vitae ullamcorper turpis, ut pharetra erat. Integer vitae erat quis augue pellentesque gravida. Nam at lorem ex. Suspendisse et mi blandit purus hendrerit dictum vel in purus. Ut ultrices non augue eu laoreet. Praesent ac mattis leo. Suspendisse a nisi neque. Etiam urna diam, scelerisque ultricies lorem non, cursus porttitor neque. In hac habitasse platea dictumst.</p>
        <aside align="right">
            <img src="/3567801.jpg" width="500" height=500f
        </aside>
    </main>

    <Footer />
</div>
  )
}
