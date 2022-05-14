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
        <p align="left">  fermentum mi laoreet ac. Phasellus mattis nisl ut ipsum feugiat</p>
        <aside align="right">
            <img src="/3567801.jpg" width="500" height=500f
        </aside>
    </main>

    <Footer />
</div>
  )
}
